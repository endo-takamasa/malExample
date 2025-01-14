import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { ConfirmDialogComponent } from '../../tools/confirm-dialog/confirm-dialog.component';

import { User } from '../user';
import { UserService } from '../user.service';

@Component({
	selector: 'app-user-edit',
	imports: [FormsModule, RouterModule],
	templateUrl: './user-edit.component.html',
	styleUrl: './user-edit.component.css'
})
export class UserEditComponent implements OnInit {
	user: User = { id: 0, name: '', email: '' ,newflag: false};
	constructor(private route: ActivatedRoute,
		private router: Router,
		private service: UserService,
		private dialog: MatDialog
	) { }
	ngOnInit(): void {
		const id = Number(this.route.snapshot.paramMap.get('id'));
		this.service.getUser(id).subscribe(res => {
			this.user = res;
		});
	}
	onSubmit(form: any): void {
		let user = {
			id: form.id,
			name: form.name,
			email: form.email,
			newflag: form.newflag
		};
		let dialogRef = this.dialog.open(ConfirmDialogComponent, {
			width: '300px',
			disableClose: true,
			data: {
				title: 'Confirm',
				message: '更新する?',
				isLoading: false
			}
		});

		dialogRef.afterClosed().subscribe(result => {
			if (result === true) {
				this.service.setUser(user).subscribe({next: () => {
					dialogRef.close();
					this.router.navigate(["/users"]);
			}});
			}
		});
	}
}