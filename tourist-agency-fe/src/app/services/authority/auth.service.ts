import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private readonly LOCAL_STORAGE_USER: string = 'currentUser';
  private readonly LOCAL_STORAGE_USER_TOKEN: string = 'userToken';

  private currentUserSubject: BehaviorSubject<any>;
  private currentUser: Observable<any>;

  constructor() { }

  public isAuthenticated(): boolean {
    return !!localStorage.getItem(this.LOCAL_STORAGE_USER);
  }

  public getCurrentUserValue(): any {
    return this.currentUserSubject.value;
  }

  public logout(): void {
    localStorage.removeItem(this.LOCAL_STORAGE_USER);
    localStorage.removeItem(this.LOCAL_STORAGE_USER_TOKEN);
    this.currentUserSubject.next(null);
  }

}
