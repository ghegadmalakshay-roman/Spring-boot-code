import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, map } from 'rxjs';
import { EmployeeResponse } from '../model/interface/employee-response';
import { EmployeeFormRequest } from '../model/class/employee-form-request';

interface ApiResponse<T> {
  data: T;
  success: boolean;
  message: string;
}

@Injectable({ providedIn: 'root' })
export class EmployeeService {
  private baseUrl = 'http://localhost:8080/api/employees';

  constructor(private http: HttpClient) { }

  getAllEmployees(): Observable<EmployeeResponse[]> {
    return this.http.get<ApiResponse<EmployeeResponse[]>>(this.baseUrl)
      .pipe(map(res => res.data));
  }

  searchEmployees(search: string): Observable<EmployeeResponse[]> {
    return this.http.get<ApiResponse<EmployeeResponse[]>>(`${this.baseUrl}/search?search=${search}`)
      .pipe(map(res => res.data));
  }

  createEmployee(employee: EmployeeFormRequest): Observable<EmployeeResponse> {
    return this.http.post<ApiResponse<EmployeeResponse>>(this.baseUrl, employee)
      .pipe(map(res => res.data));
  }
}
