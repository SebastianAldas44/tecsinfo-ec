import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Producto } from '../models/producto';
import { Global } from './global';
import { Observable } from 'rxjs';
//import { Observable } from 'rxjs/Observable'; cmd(npm install --save rxjs-compat)

@Injectable()
export class ProductoService{
	public url: string;

	constructor(
		private _http: HttpClient
	){
		this.url = Global.url;
	}

	getProductos(): Observable<any>
	{
		let headers = new HttpHeaders().set('Content-type', 'application/json');

		return this._http.get(this.url + "productos/", {headers: headers});
	}

	getProducto(codigo): Observable<any>
	{
		let headers = new HttpHeaders().set('Content-type', 'application/json');

		return this._http.get(this.url + "producto/?codigo=" + codigo, {headers: headers});
	}
}