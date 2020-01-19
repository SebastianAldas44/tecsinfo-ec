import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LoginComponent } from './components/login/login.component';
import { ProductoComponent } from './components/producto/producto.component';

const appRoutes: Routes = [
	{path: '', component: LoginComponent},
	{path: 'login', component: LoginComponent},
	{path: 'productos', component: ProductoComponent},
	{path: '**', component: LoginComponent}
];

export const AppRoutingProviders: any[] = [];
export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);