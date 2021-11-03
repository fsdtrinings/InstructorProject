import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Instructor } from '../instructor';
import { InstructorServiceService } from '../instructor-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-update-instructor',
  templateUrl: './update-instructor.component.html',
  styleUrls: ['./update-instructor.component.css']
})
export class UpdateInstructorComponent implements OnInit {

  id!:number;
  oldlocation!:string;
  newtrainerlocation !:string;

  instructor:Instructor = new Instructor();
  constructor(private activatedRouter:ActivatedRoute,
    private insService:InstructorServiceService,
    private router:Router) { }

  ngOnInit(): void {
    this.id = this.activatedRouter.snapshot.params['id'];
    this.oldlocation = this.activatedRouter.snapshot.params['location'];

    console.log("update component :- "+this.id+" and "+this.oldlocation);
  }

  doUpdateOnServer()
  {
    console.log("Id "+this.id);
    console.log("Old Location "+this.oldlocation);
    console.log("New Selected location :- "+this.newtrainerlocation);
    this.insService.updateInstructor(this.id,this.newtrainerlocation)
        .subscribe(data=>{
          this.instructor = data;
          console.log(" Data Updted !!! "+this.instructor.name+" location "+ this.instructor.trainerlocation);
        },
        error=>console.log(error)
        );
        this.router.navigate(['instructors']);
  }

}
