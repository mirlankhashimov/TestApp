package com.mirlan.testapp

import android.app.Application
import androidx.room.Room
import com.mirlan.testapp.database.ItemsDatabase
import com.mirlan.testapp.repository.ItemsRepository
import com.mirlan.testapp.ui.ItemsViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.logger.AndroidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            AndroidLogger()
            androidContext(this@App)
            modules(appModule)
        }
    }
    private val appModule = module{

        single {
            Room.databaseBuilder(get(), ItemsDatabase::class.java, "items-db")
                .fallbackToDestructiveMigration()
                .build()
        }
        single { ItemsRepository(get()) }

        viewModel { ItemsViewModel(get()) }
    }
}