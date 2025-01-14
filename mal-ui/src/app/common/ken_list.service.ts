import { Injectable, OnInit } from '@angular/core';
import { Observable} from 'rxjs';

export class Ken {
  id: number;
  name: string;

  constructor(id: number, name: string) {
    this.id = id;
    this.name = name;
  }
}

@Injectable({
  providedIn: 'root'
})
export class KenService {
	disp_kens: Ken[] = [];

	//ngOnInit(): void {
	createKenList(): void {
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