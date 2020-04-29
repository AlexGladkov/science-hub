package di

import org.kodein.di.Kodein

val kodein = Kodein {
    import(spaceXModule)
}