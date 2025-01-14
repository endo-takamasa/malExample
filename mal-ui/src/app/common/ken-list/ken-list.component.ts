import { Component, Input, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-ken-list',
  imports: [CommonModule,FormsModule],
  templateUrl: './ken-list.component.html',
  styleUrl: './ken-list.component.css',
})
export class KenListComponent implements OnInit {
	disp_kens: Ken[] = [];
	my_value: string = '';
	disp_list: resultListRow[] = [];

	/** コード定義番号 */
	@Input() master_no: string='';

	/** listのパーツ名 */
	@Input() id_and_name: string='';

	ngOnInit(): void {
		const testhensu = this.master_no;
		// ドロップダウンリストを生成
		//this.disp_kens = [];
		//this.createKenList();
		this.disp_list = this.createList(this.master_no);
	}
	createList(arg_0: string): resultListRow[] {
		var return_list: resultListRow[] = [];
		
		// 本来ならjava側にmaster_noを渡してSQL実行する
		if(arg_0==='106'){
			var addKen1 = new resultListRow(1,'北海道');
			return_list.push(addKen1);
			var addKen1 = new resultListRow(2,'山形');
			return_list.push(addKen1);
			var addKen1 = new resultListRow(3,'宮城');
			return_list.push(addKen1);
			var addKen1 = new resultListRow(4,'東京');
			return_list.push(addKen1);
		}else if(arg_0==='107'){
			var addKen1 = new resultListRow(1,'仙台市');
			return_list.push(addKen1);
			var addKen1 = new resultListRow(2,'石巻市');
			return_list.push(addKen1);
			var addKen1 = new resultListRow(3,'気仙沼市');
			return_list.push(addKen1);
			var addKen1 = new resultListRow(4,'多賀城市');
			return_list.push(addKen1);
			var addKen1 = new resultListRow(4,'大和町');
			return_list.push(addKen1);
		}

		return return_list
	}
	//ngOnInit(): void {
	createKenList():void  {
		var addKen1 = new Ken(1,'北海道');
		this.disp_kens.push(addKen1);
		var addKen1 = new Ken(2,'山形');
		this.disp_kens.push(addKen1);
		var addKen1 = new Ken(3,'宮城');
		this.disp_kens.push(addKen1);
		var addKen1 = new Ken(4,'東京');
		this.disp_kens.push(addKen1);
	}
}

export class Ken {
  id: number;
  name: string;

  constructor(id: number, name: string) {
    this.id = id;
    this.name = name;
  }
}

export class resultListRow {
	id: number;
	name: string;
  
	constructor(id: number, name: string) {
	  this.id = id;
	  this.name = name;
	}
  }

function elseif(arg0: string) {
	throw new Error('Function not implemented.');
}
