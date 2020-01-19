import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Usuario } from '../models/usuario';
import { Global } from './global';
import { Observable } from 'rxjs';
//import { Observable } from 'rxjs/Observable'; cmd(npm install --save rxjs-compat)

@Injectable()
export class UsuarioService{
	public url: string;

	constructor(
		private _http: HttpClient
	){
		this.url = Global.url;
	}

	getUsuarios(): Observable<any>
	{
		let headers = new HttpHeaders().set('Content-type', 'application/json');

		return this._http.get(this.url + "usuarios/", {headers: headers});
	}

	getUsuario(usuario: Usuario): Observable<any>
	{
		let headers = new HttpHeaders().set('Content-type', 'application/json');
		
		return this._http.post(this.url + "usuario/", usuario, {headers: headers});
	}
}