import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

import { Profile } from './profile';

@Injectable({
	providedIn: 'root'
})
export class ProfileService {
    private users: Profile[] = [];  // プライベートプロパティ
    private url = 'http://localhost:8080/mal_demo';

    constructor(private http: HttpClient) { }

    // 他のメソッド（例: ユーザー取得）
    getProfile(id: string): Observable<Profile> {
        return this.http.get<Profile>(`${this.url}/getProfile/${id}`)
            .pipe(
                catchError(this.handleError<Profile>(`getProfile id=${id}`))
            );
    }

    // ユーザーを更新するメソッド
    saveProfile(user: Profile): Observable<Profile> {
        const formData = new FormData();
        formData.append('id', user.id);
        formData.append('ken', user.ken);
        formData.append('name', user.name);
        formData.append('pass', user.pass);
        return this.http.put<Profile>(`${this.url}/editProfile`, formData)
            .pipe(
                catchError(this.handleError<Profile>(`editProfile`))
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
 