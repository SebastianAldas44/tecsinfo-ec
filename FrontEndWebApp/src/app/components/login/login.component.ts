import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Usuario } from '../../models/usuario';
import { UsuarioService } from '../../services/usuario.service';
import { Global } from '../../services/global';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [UsuarioService]
})
export class LoginComponent implements OnInit {
	public usuario: Usuario;
	public url: string;

  	constructor(
  		private _usuarioService: UsuarioService,
  		private router: Router
  	) {
  		this.url = Global.url;
  		this.usuario = new Usuario('', '', '');
  	}

  	ngOnInit() {
  	}

  	getUsuarios()
  	{
  		this._usuarioService.getUsuarios().subscribe(
  			response => {
  				console.log(response);
	  		}, error => {
	  			console.log(error);
			}
		);
  	}

  	onSubmit(form)
  	{
  		this._usuarioService.getUsuario(this.usuario).subscribe(
  			response => {
  				if(response.nombre != "no_existe")
  				{
  					alert("Bienvenido " + response.nombre);
  					this.router.navigate(['productos']);
  				}
  				else
  					alert("Nick de usuario y/o contraseña no son correctas");
  			},
  			error => {
  				console.log(error);
  			}
  		);
  	}

}
