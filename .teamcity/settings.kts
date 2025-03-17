import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.perfmon
import jetbrains.buildServer.configs.kotlin.triggers.vcs

version = "2024.12"

project {

    buildType(Build)
}

object Build : BuildType({
    name = "Build"

    vcs {
        root(DslContext.settingsRoot)
    }

steps{
    script{
        name = "Installing npm packages"
        scriptContent= """ npm install """
    }

    script{
        name = "Run tests"
        scriptContent = """ npm run verify """
    }
    
}
    triggers {
        vcs {
        }
    }

    features {
        perfmon {
        }
    }
})
