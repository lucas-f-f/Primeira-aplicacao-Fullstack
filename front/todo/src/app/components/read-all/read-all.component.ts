import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Todo } from "src/app/models/todo";
import { TodoService } from "src/app/services/todo.service";

@Component({
  selector: "app-read-all",
  templateUrl: "./read-all.component.html",
  styleUrls: ["./read-all.component.css"],
})
export class ReadAllComponent implements OnInit {
  
  closed = 0;
  
  list: Todo[] = [];
  listFinished: Todo[] = [];
  constructor(private service: TodoService,private router:Router) {}

  
  /**Methods */
  ngOnInit(): void {
    this.findAll();
    
  }

  findAll(): void {
    this.service.findAll().subscribe((resposta) => {
      resposta.forEach(todo => {
        if(todo.finalizado){
          this.listFinished.push(todo);
        }else{
            this.list.push(todo)
          }
        }
      )
      this.closed = this.listFinished.length
     /**  this.countClosed();*/
    });
  }

 /**  countClosed(): void {
    for(let todo of this.list){
      if(todo.finalizado){
        this.closed++
      }
    }
  }*/
// Metodo delete
delete(id: any): void{
  this.service.delete(id).subscribe((resposta) =>{
    if (resposta ===null){
      this.service.message('Task deletada com sucesso!');
      this.list = this.list.filter((todo) => todo.id !== id);
    }
  })
}

}
