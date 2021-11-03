import { Component, OnInit } from '@angular/core';
import { Instructor } from '../instructor';
import { InstructorServiceService } from '../instructor-service.service';

@Component({
  selector: 'app-search-instructor',
  templateUrl: './search-instructor.component.html',
  styleUrls: ['./search-instructor.component.css']
})
export class SearchInstructorComponent implements OnInit {

  searchId!:number;
  instructor :Instructor= new Instructor();
  status : boolean=false;
  show : boolean=false;
  expLevel !: string;
  
  constructor(private insService:InstructorServiceService) { }

  ngOnInit(): void {
  }

  searchInstructor()
  {
    
    this.insService.searchInstructor(this.searchId)
    .subscribe(data=>{
      console.log(" Instructor Searched !!! "+data);
      this.instructor = data;
      console.log(this.instructor);
      this.status = true;
      this.show = true;
      let exp = this.instructor.jobstartyear;
      let currentYear = new Date().getFullYear();

      if(currentYear - exp > 10) this.expLevel = 'Senior Consultant';
      else if((currentYear - exp < 9)&&(currentYear -exp > 5)) this.expLevel = 'Senior Trainer';
      else if(currentYear - exp < 5) this.expLevel = 'Associate Trainer';
      


    },
    error=>{
      console.log(error)
      this.show = true; // make things visible only
    }
    );
    


  }

}
