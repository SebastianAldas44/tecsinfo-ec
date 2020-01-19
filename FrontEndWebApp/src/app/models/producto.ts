export class Producto{
	constructor(
		public codigo: number,
		public descripcion: string,
		public precio: number,
		public cantidad: number,
		public total: number
	){}
}