import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';

import { User } from '../user';
import { UserService } from '../user.service';

import { ConfirmDialogComponent } from '../../tools/confirm-dialog/confirm-dialog.component';

@Component({
	selector: 'app-user-list',
	imports: [CommonModule, RouterModule, FormsModule],
	templateUrl: './user-list.component.html',
	styleUrl: './user-list.component.css'
})
export class UserListComponent implements OnInit {
	users: User[] = [];

	constructor(
		private service: UserService
		,private route: ActivatedRoute
		,private router: Router
		,private dialog: MatDialog
	) { }

	ngOnInit(): void {
		this.service.getUsers().subscribe(res => {
			this.users = res;
		});
	}

	onAddButton() {
		var maxId:  number = 0;
		this.users.forEach(element => {
			if(element.id > maxId){
				maxId=element.id;
			}
		});
		var adduser: User = { id: maxId+1, name: '', email: '' ,newflag: true};
		this.users.push(adduser);
	}

	onDelButton(targetid: number) {
		var newusers: User[] = [];
		var nowId: number = 1;
		this.users.forEach(element => {
			if(element.id != targetid){
				element.id = nowId;
				newusers.push(element);
				nowId=nowId+1;
			}
		});

		this.users = newusers;
	}

	onSubmit(form: any): void {

		let dialogRef = this.dialog.open(ConfirmDialogComponent, {
			width: '300px',
			disableClose: true,
			data: {
				title: 'Confirm',
				message: '確定しますか？',
				isLoading: false
			}
		});

		dialogRef.afterClosed().subscribe(result => {
			if (result === true) {
				this.service.setUsers(this.users).subscribe({next: () => {
					dialogRef.close();
					this.router.navigate(["/users"]);
				}});
				this.service.getUsers().subscribe(res => {
					this.users = res;
				});
			}
		});
	}
}