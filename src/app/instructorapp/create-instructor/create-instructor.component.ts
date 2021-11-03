import { Component, OnInit } from '@angular/core';
import { Instructor } from '../instructor';
import { InstructorServiceService } from '../instructor-service.service';

@Component({
  selector: 'app-create-instructor',
  templateUrl: './create-instructor.component.html',
  styleUrls: ['./create-instructor.component.css']
})
export class CreateInstructorComponent implements OnInit {

  instructor:Instructor = new Instructor();

  constructor(private instructorService:InstructorServiceService) { }

  ngOnInit(): void {
  }

  onSubmit()
  {
    console.log(this.instructor);
    this.doSaveTOServer();
  }

  doSaveTOServer()
  {
    this.instructorService.createInstructor(this.instructor).subscribe(
      data=>{
          console.log(" Data Saved !!! "+data);
      },
      error => {
        console.log(error);
        
      }
     );
  }

}
