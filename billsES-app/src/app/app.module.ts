import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ClientesComponent } from './components/clientes/clientes.component';
import { FormularioClienteComponent } from './components/clientes/formulario-cliente/formulario-cliente.component';
import { FooterComponent } from './components/footer/footer.component';
import { HeaderComponent } from './components/header/header.component';
import { MenuComponent } from './components/menu/menu.component';
import { UsuariosComponent } from './components/usuarios/usuarios.component';
import { UsuarioService } from './services/usuario.service';
import { HttpClientModule } from '@angular/common/http';
import { HttpClientService } from './services/http-client.service';
import { FormUsuariosComponent } from './components/usuarios/form-usuarios.component';
import { ProductosComponent } from './components/productos/productos.component';
import { FormProductosComponent } from './components/productos/form-productos.component';
import { ProductoService } from './services/producto.service';
import { CategoriaService } from './services/categoria.service';
import { CategoriasComponent } from './components/categorias/categorias.component';
import { FormCategoriasComponent } from './components/categorias/form-categorias.component';
import { MarcasComponent } from './components/marcas/marcas.component';
import { FormMarcasComponent } from './components/marcas/form-marcas.component';
import { RevisionesComponent } from './components/revisiones/revisiones.component';
import { FormRevisionesComponent } from './components/revisiones/form-revisiones.component';
import { CarritoComponent } from './components/carrito/carrito.component';
import { PedidoComponent } from './components-users/pedido/pedido.component';
import { PedidosComponent } from './components/pedidos/pedidos.component';
import { FormPedidosComponent } from './components/pedidos/form-pedidos.component';

@NgModule({
  declarations: [
    AppComponent,
    ClientesComponent,
    FormularioClienteComponent,
    FooterComponent,
    HeaderComponent,
    MenuComponent,
    UsuariosComponent,
    FormUsuariosComponent,
    ProductosComponent,
    FormProductosComponent,
    CategoriasComponent,
    FormCategoriasComponent,
    MarcasComponent,
    FormMarcasComponent,
    RevisionesComponent,
    FormRevisionesComponent,
    CarritoComponent,
    PedidoComponent,
    PedidosComponent,
    FormPedidosComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [ UsuarioService, HttpClientService, ProductoService, CategoriaService],
  bootstrap: [AppComponent]
})
export class AppModule { }
