import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { FormGroup, FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { ConfirmDialogComponent } from '../../tools/confirm-dialog/confirm-dialog.component';
import { FormControl } from '@angular/forms';
import { KenListComponent } from '../../common/ken-list/ken-list.component';

import { Profile } from '../profile';
import { ProfileService } from '../profile.service';
//import { Ken, KenService } from '../../common/ken_list.service';

@Component({
  selector: 'app-user-set',
	imports: [CommonModule, RouterModule, FormsModule, KenListComponent, ReactiveFormsModule],
  templateUrl: './user-set.component.html',
  styleUrl: './user-set.component.css'
})
export class UserSetComponent implements OnInit {
  my_profile: Profile = {id: '0', ken: '', name: '', pass: '', sityou: ''};
  //kens: Ken[] = []; // ドロップダウン表示リスト
  selectedKenControl = new FormControl();
  comp_msg: string = '';
  ken: string = '';

  //ここが重要
  testForm = new FormGroup({
    id: new FormControl('', []),
    ken: new FormControl('', []),
    name: new FormControl('', []),
    pass: new FormControl('', []),
    sityou: new FormControl('', [])
  });


  constructor(private route: ActivatedRoute,
    private router: Router,
    private service: ProfileService,
    private dialog: MatDialog,
    //private kenService: KenService
  ) { }

  ngOnInit(): void {
    //とりあえずmenu.component.htmlで999を投げているので999が取れる想定
    const id = String(this.route.snapshot.paramMap.get('id'));
    
    // ドロップダウンリストを生成
    //this.kenService.disp_kens = [];
    //this.kenService.createKenList();
    //this.kens = this.kenService.disp_kens;
    // ドロップダウンの初期値を設定
    //this.selectedKenControl = new FormControl(this.kens[0].id);

    this.service.getProfile(id).subscribe(res => {
			this.my_profile = res;
		});
  }

  onSubmit(form: any): void {
    let input_profile = {
      id: form.id,
      ken: form.ken,
      sityou: form.sityou,
      name: form.name,
      pass: form.pass
    };
    let dialogRef = this.dialog.open(ConfirmDialogComponent, {
      width: '300px',
      disableClose: true,
      data: {
        title: 'Confirm',
        message: '更新しますか？',
        isLoading: false
      }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result === true) {
        this.service.saveProfile(input_profile).subscribe({next: () => {
          dialogRef.close();
          this.router.navigate(["/userSet/{form.id}"]);
          const nowDate = new Date();
          this.comp_msg = '更新完了('+nowDate+')';
      }});
      }
    });
  }

  //compareKen(ken1: Ken, ken2: Ken): boolean {
	//	return ken1.id === ken2.id;
	//}
}
