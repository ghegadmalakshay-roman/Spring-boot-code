import { Routes } from '@angular/router';
import { HomeComponent } from './component/home/home.component';
import { SearchComponent } from './component/search/search.component';
import { EmployeeComponent } from './component/employee/employee.component';


export const routes: Routes = [

    {
        path: '',
        redirectTo: 'home',
        pathMatch: 'full'
    },

    {
        path: 'home',
        component: HomeComponent
    },


    {
        path: 'employee',
        component: EmployeeComponent
    },

    {
        path: '**',
        redirectTo: 'home'
    }

];

