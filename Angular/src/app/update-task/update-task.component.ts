import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Action } from 'rxjs/internal/scheduler/Action';
import { Task } from '../task';
import { TaskService } from '../task.service';

@Component({
  selector: 'app-update-task',
  templateUrl: './update-task.component.html',
  styleUrls: ['./update-task.component.css']
})
export class UpdateTaskComponent implements OnInit {

  id: number;
  task: Task;

  constructor(private taskService: TaskService,
    private route: ActivatedRoute, private router: Router) { }
 
  ngOnInit(): void {
    this.task = new Task();

    this.id = this.route.snapshot.params['id'];

    this.taskService.getTaskById(this.id).subscribe(data => {
      console.log(data)
      this.task = data;
    }, error => console.log(error));
  }

  onSubmit(){
    this.taskService.updateTask(this.id, this.task).subscribe(data =>{
      this.goToTaskList();
    }
    ,error => console.log(error));
  }

  goToTaskList(){
    this.router.navigate(['/tasks']);
  }

}
