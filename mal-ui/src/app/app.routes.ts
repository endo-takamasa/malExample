import { Routes } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { UserListComponent } from './user/user-list/user-list.component';
import { UserEditComponent } from './user/user-edit/user-edit.component';
import { UserSetComponent } from './user/user-set/user-set.component';

export const routes: Routes = [
	{ path: '', redirectTo: '/dashboard', pathMatch: 'full' },
	{ path: 'dashboard', component: DashboardComponent },
	{ path: 'users', component: UserListComponent },
	{ path: 'users/:id/edit', component: UserEditComponent },
	{ path: 'userSet/:id', component: UserSetComponent },
];
