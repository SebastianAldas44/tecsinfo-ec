import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { routing, AppRoutingProviders } from './app.routing';

import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { ProductoComponent } from './components/producto/producto.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ProductoComponent
  ],
  imports: [
    BrowserModule,
    routing,
    HttpClientModule,
    FormsModule
  ],
  providers: [
  	AppRoutingProviders
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
