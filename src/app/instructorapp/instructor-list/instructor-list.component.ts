import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {Instructor} from '../instructor';
import {InstructorServiceService} from '../instructor-service.service'
import {NgxPaginationModule} from 'ngx-pagination';

@Component({
  selector: 'app-instructor-list',
  templateUrl: './instructor-list.component.html',
  styleUrls: ['./instructor-list.component.css']
})
export class InstructorListComponent implements OnInit {

  instructors !: Instructor[];

 
  totalRecords:number=0;
  page:number=1;

  constructor(private instructorService:InstructorServiceService,
    private router:Router) { 

  }

  ngOnInit(): void {
    this.getInstructors();
  }

  private getInstructors()
  {
    this.instructorService.getAllInstructorList().subscribe(data=>{
        this.instructors = data;
        this.totalRecords = data.length;
    },
    err=>
    {
      console.log(err.error);
    }
    
    );
  }

  updateInstructorLocation(id:number,location:string)
  {
    console.log("update button clicked "+id+" "+location);
    this.router.navigate(['editlocation',id,location]);
  }

}//end component class
