import { Component, ViewChild, OnInit, AfterViewInit } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';

import { EmployeeService } from '../../service/employee.service';
import { EmployeeResponse } from '../../model/interface/employee-response';
import { MatDialog } from '@angular/material/dialog';
import { EmployeeComponent } from '../employee/employee.component';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    MatTableModule,
    MatPaginatorModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent implements OnInit, AfterViewInit {

  // 🔹 MUST match matColumnDef in HTML
  displayedColumns: string[] = [
    'empId',
    'empName',
    'adhar',
    'email',
    'phone',
    'address',
    'gender',
    'country',
    'state'
  ];

  dataSource = new MatTableDataSource<EmployeeResponse>([]);

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(

    private employeeService: EmployeeService,
    private dialog: MatDialog

  ) { }

  // 🔹 Page load → API call
  ngOnInit(): void {
    this.getAllEmployees();
  }

  // 🔹 Attach paginator after view init
  ngAfterViewInit(): void {
    this.dataSource.paginator = this.paginator;
  }

  // 🔹 GET ALL EMPLOYEES
  getAllEmployees(): void {
    this.employeeService.getAllEmployees().subscribe({
      next: (res) => {
        this.dataSource.data = res;
        if (this.paginator) {
          this.paginator.firstPage();
        }
      },
      error: (err) => {
        console.error('Error fetching employees', err);
        this.dataSource.data = [];
      }
    });
  }

  // 🔹 SEARCH EMPLOYEE (Backend)
  applyFilter(event: Event): void {
    const keyword = (event.target as HTMLInputElement).value.trim();

    if (!keyword) {
      this.getAllEmployees();
      return;
    }

    this.employeeService.searchEmployees(keyword).subscribe({
      next: (res) => {
        this.dataSource.data = res;
        if (this.paginator) {
          this.paginator.firstPage();
        }
      },
      error: (err) => {
        console.error('Search error', err);
        this.dataSource.data = [];
      }
    });
  }

  openAddEmployee(): void {
    const dialogRef = this.dialog.open(EmployeeComponent, {
      width: '450px',
      disableClose: true
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result === 'SUCCESS') {
        this.getAllEmployees(); // ✅ table refresh
      }
    });
  }
}
