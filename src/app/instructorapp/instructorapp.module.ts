import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { InstructorListComponent } from './instructor-list/instructor-list.component';
import { CreateInstructorComponent } from './create-instructor/create-instructor.component';
import { FormsModule} from '@angular/forms';
import { UpdateInstructorComponent } from './update-instructor/update-instructor.component';
import {NgxPaginationModule} from 'ngx-pagination';
import { SearchInstructorComponent } from './search-instructor/search-instructor.component';

@NgModule({
  declarations: [InstructorListComponent, 
    CreateInstructorComponent, 
    UpdateInstructorComponent, SearchInstructorComponent],
  imports: [
    CommonModule,
    FormsModule,
    NgxPaginationModule
  ],
  exports:[
    InstructorListComponent,
    CreateInstructorComponent,
    FormsModule
  ]
})
export class InstructorappModule { 
 
}
