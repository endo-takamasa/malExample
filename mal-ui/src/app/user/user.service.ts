import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

import { User } from './user';

@Injectable({
	providedIn: 'root'
})
export class UserService {
    private users: User[] = [];  // プライベートプロパティ
    private url = 'http://localhost:8080/mal_demo';

    constructor(private http: HttpClient) { }

    // getUsersメソッドをクラス内に定義（コンストラクタの外側）
    getUsers(): Observable<User[]> {
        return this.http.get<User[]>(`${this.url}/users`)
        .pipe(
        catchError(this.handleError('getUsers', []))
        );
    }

    // 他のメソッド（例: ユーザー取得）
    getUser(id: number): Observable<User> {
        return this.http.get<User>(`${this.url}/user/${id}`)
            .pipe(
                catchError(this.handleError<User>(`getUser id=${id}`))
            );
    }

    // ユーザーを更新するメソッド（全行）
    setUsers(entry_users: User[]): Observable<User[]> {
        var formDatas: FormData[] = []; 
        const formData = new FormData();
        entry_users.forEach(element => {

            formData.append('id[]', element.id.toString());
            formData.append('name[]', element.name);
            formData.append('email[]', element.email);
        });

        return this.http.put<User[]>(`${this.url}/editUsers`, formData)
            .pipe(
                catchError(this.handleError<User[]>(`setUser`))
            );
    }
    // ユーザーを更新するメソッド
    setUser(user: User): Observable<User> {
        const formData = new FormData();
        formData.append('id', user.id.toString());
        formData.append('name', user.name);
        formData.append('email', user.email);
        return this.http.put<User>(`${this.url}/editUser`, formData)
            .pipe(
                catchError(this.handleError<User>(`setUser`))
            );
    }
    private handleError<T>(operation = 'operation', result?: T) {
        return (error: any): Observable<T> => {
            console.error(error);
            console.log(`${operation} failed: ${error.message}`);
            return of(result as T);
        };
    }
}
 