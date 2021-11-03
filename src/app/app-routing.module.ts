import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateInstructorComponent } from './instructorapp/create-instructor/create-instructor.component';
import { InstructorListComponent } from './instructorapp/instructor-list/instructor-list.component';
import { UpdateInstructorComponent } from './instructorapp/update-instructor/update-instructor.component';
import {SearchInstructorComponent} from './instructorapp/search-instructor/search-instructor.component';

const routes: Routes = [
  {path:'instructors',component:InstructorListComponent},
  {path:'createInstructor',component:CreateInstructorComponent},
  {path:'editlocation/:id/:location',component:UpdateInstructorComponent},
  {path:'search',component:SearchInstructorComponent},
  {path:'', redirectTo:'instructors',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
