package com.example.counter


class Presenter constructor(val view: CounterView) {

    private val model = Model()

    fun increment() {
        model.increment()
        view.showCounter(model.count)
        if (model.count == 10) {
            view.showToast()
        }
        if (model.count == 15) {
            view.changeColor()
        }
    }

    fun decrement() {
        model.decrement()
        view.showCounter(model.count)
    }
}