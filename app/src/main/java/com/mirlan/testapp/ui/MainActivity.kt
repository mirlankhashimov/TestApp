package com.mirlan.testapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.mirlan.testapp.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val adapter = ItemsAdapter()
    private val viewModel: ItemsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv_list.adapter = adapter
        viewModel.items.observe(this, Observer { adapter.submitList(it) })
    }

}
//Тестовое задание
//
//В базе данных, доступ к которой нужно реализовать через orm ROOM содержится 10 000 записей вида
//
//порядковый номер
//признак левое или правое
//признак текст или картинка
//
//и связанная с этой сущностью вторая, содержащая поля
//
//текст - буквы алфавита
//
//Реализовать программу отображения данных из базы в recycleView по следующему правилу:
//
//если признак "левое" - в списке элемент выравнивается по левому краю
//если признак "правое" - в списке элемент выравнивается по правому краю
//текст - буквы алфавита
//если признак "картинка", то отображать любую картинку рядом с текстом
//если признак "текст", то отображать рядом с текстом префикс "текст"
//
//при реализации использовать технологии:
//coroutines, room, android jetpack, kodein (не обязательно)
