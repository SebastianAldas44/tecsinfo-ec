import { Component, OnInit } from '@angular/core';
import { Producto } from '../../models/producto';
import { ProductoService } from '../../services/producto.service';
import { Global } from '../../services/global';

@Component({
  selector: 'app-producto',
  templateUrl: './producto.component.html',
  styleUrls: ['./producto.component.css'],
  providers: [ProductoService]
})
export class ProductoComponent implements OnInit {
	public url: string;
	public productos: Producto[];

  	constructor(
  		private _productoService: ProductoService
  	) {
  		this.url = Global.url;
  	}

  	ngOnInit() {
  		this.getProductos();
  	}

  	getProductos()
  	{
  		this._productoService.getProductos().subscribe(
  			response => {
  				console.log(response);
  				this.productos = response;
			},
			error => {
				console.log(error);
			}
  		);
  	}

}
