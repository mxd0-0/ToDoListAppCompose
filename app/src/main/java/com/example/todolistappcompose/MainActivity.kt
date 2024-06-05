package com.example.todolistappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todolistappcompose.ui.theme.ToDoListAppComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

        }
    }
}

@Composable
fun TodoListApp(modifier: Modifier = Modifier) {

    var task by remember { mutableStateOf("") }
    var tasks by remember { mutableStateOf(listOf<String>()) }

    Column(modifier = modifier
        .fillMaxSize()
        .padding(16.dp)
        .background(Color.Black)) {
        BasicTextField(
            value = task, onValueChange = {task = it}, modifier = modifier.fillMaxWidth()
                .padding(8.dp), singleLine = true, textStyle = TextStyle(fontSize = 18.sp)

        )
        Button(
            onClick = {
                if (task.isNotEmpty()) {
                    tasks = tasks + task
                    task = ""
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text("Add Task")
        }
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(tasks) { task ->
                TaskItem(task = task)
            }
        }



    }
    
}
@Composable
fun TaskItem(task: String) {
    var isChecked by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = task,
            fontSize = 18.sp,
            modifier = Modifier.weight(1f)
        )

        Checkbox(
            checked = isChecked,
            onCheckedChange = { isChecked = it }
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun preview() {
    TodoListApp()
}