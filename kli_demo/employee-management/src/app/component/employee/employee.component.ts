import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';

import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';

import { EmployeeService } from '../../service/employee.service';
import { EmployeeFormRequest } from '../../model/class/employee-form-request';
import { MatIcon } from "@angular/material/icon";



@Component({
  selector: 'app-employee',
  imports: [
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatIcon
],
  templateUrl: './employee.component.html',
  styleUrl: './employee.component.scss'
})
export class EmployeeComponent {

  
  employeeForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private employeeService: EmployeeService,
    private dialogRef: MatDialogRef<EmployeeComponent>
  ) {
    this.employeeForm = this.fb.group({
      empId: ['', Validators.required],
      empName: ['', Validators.required],
      adhar: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      phone: ['', Validators.required],
      gender: ['', Validators.required],
      address: ['', Validators.required],
      state: ['', Validators.required],
      country: ['', Validators.required]
    });
  }

  submit(): void {
    if (this.employeeForm.invalid) {
      return;
    }

    const payload: EmployeeFormRequest = this.employeeForm.value;

    this.employeeService.createEmployee(payload).subscribe({
      next: () => {
        this.dialogRef.close('SUCCESS'); // ✅ Home ko signal
      },
      error: (err) => {
        console.error('Create employee failed', err);
      }
    });
  }

  close(): void {
    this.dialogRef.close();
  }

}
