import { HttpClient } from '@angular/common/http';
import { stringify } from '@angular/compiler/src/util';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Instructor } from './instructor';

@Injectable({
  providedIn: 'root'
})
export class InstructorServiceService {

  /* Test:- Spring boot embedded Server */
  //private address = 'http://localhost:9001';

  /* deployed server */
  private address = 'http://localhost:8010/SpringREST-Hibernate-0.0.1-SNAPSHOT';

  private getAllInstructor_endpoint = this.address+'/jpa/trainers';
  private endpoint = this.address+'/jpa/trainer';
  private search_endpoint = this.address+'/trainer';

  constructor(private http:HttpClient) { }

  getAllInstructorList():Observable<Instructor[]>
  {
    console.log('Instructor Service - Get Instructor called ');
    return this.http.get<Instructor[]>(`${this.getAllInstructor_endpoint}`);
  }

  createInstructor(instructor:Instructor):Observable<Object>
  {
    console.log('Instructor Service - Create Instructor called ');
    return this.http.post<Instructor>(`${this.endpoint}`,instructor);
  }

  updateInstructor(id:number,newLoc:string):Observable<Instructor>
  {
    //http://localhost:9001/jpa/trainer/784/location/Pune}

    return this.http.put<Instructor>(`${this.endpoint}/${id}/location/${newLoc}`,Instructor);
  }


  searchInstructor(id:number):Observable<Instructor>
  {
    //http://localhost:9001/jpa/trainer/784/location/Pune}

    return this.http.get<Instructor>(`${this.search_endpoint}/${id}`);
  }

}
