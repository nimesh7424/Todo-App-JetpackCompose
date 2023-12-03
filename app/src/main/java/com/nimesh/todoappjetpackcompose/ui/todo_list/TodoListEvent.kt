package com.nimesh.todoappjetpackcompose.ui.todo_list

import com.nimesh.todoappjetpackcompose.data.Todo

sealed class TodoListEvent {
    data class OnDeleteTodoCLick(val todo: Todo): TodoListEvent()
    data class OnDoneChange(val todo: Todo, val isDone: Boolean): TodoListEvent()
    object OnUndoDeleteCLick: TodoListEvent()
    data class OnTodoClick(val todo: Todo): TodoListEvent()
    object OnAddTodoClick: TodoListEvent()
}
