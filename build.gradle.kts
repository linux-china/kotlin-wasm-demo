import java.nio.file.Paths

plugins {
    kotlin("multiplatform") version "1.3.31"
}

repositories {
    // Use jcenter for resolving your dependencies.
    // You can declare any Maven/Ivy/file repository here.
    mavenCentral()
    jcenter()
}

val packageName = "kotlinx.interop.wasm.dom"
val jsinteropKlibFileName = Paths.get(buildDir.toString(), "klib", "$packageName-jsinterop.klib").toString()


kotlin {

    wasm32("native") {
        binaries {
            executable()
        }
    }
    sourceSets {
        val nativeMain by getting {
            dependencies {
                implementation(files(jsinteropKlibFileName))
            }
        }
    }

}

val jsinterop by tasks.creating(Exec::class) {
    //jsinterop -pkg kotlinx.interop.wasm.dom  -o build/klib/kotlinx.interop.wasm.dom-jsinterop.klib -target wasm32
    workingDir("./")
    executable("${project.properties["konanHome"]}/bin/jsinterop")
    args("-pkg", "kotlinx.interop.wasm.dom", "-o", jsinteropKlibFileName, "-target", "wasm32")
}

// generate jsinterop before native compile
tasks.named("compileKotlinNative") {
    dependsOn(jsinterop)
}

