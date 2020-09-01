import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UsuariosComponent } from './components/usuarios/usuarios.component';
import { FormUsuariosComponent } from './components/usuarios/form-usuarios.component';
import { ProductosComponent } from './components/productos/productos.component';
import { FormProductosComponent } from './components/productos/form-productos.component';
import { CategoriasComponent } from './components/categorias/categorias.component';
import { FormCategoriasComponent } from './components/categorias/form-categorias.component';
import { MarcasComponent } from './components/marcas/marcas.component';
import { FormMarcasComponent } from './components/marcas/form-marcas.component';
import { RevisionesComponent } from './components/revisiones/revisiones.component';
import { FormRevisionesComponent } from './components/revisiones/form-revisiones.component';
import { CategoriaService } from './services/categoria.service';



const routes: Routes = [

  { path: '', redirectTo: '/users', pathMatch: 'full'},
 /*  { path: '**', component: ClientesComponent},
  { path: '', component: ClientesComponent}, */
  { path: 'users', component: UsuariosComponent},
  { path: 'users/form', component: FormUsuariosComponent},
  { path: 'users/form/:id', component: FormUsuariosComponent },
  { path: 'products', component: ProductosComponent},
  { path: 'products/form', component: FormProductosComponent},
  { path: 'products/form/:id', component: FormProductosComponent },
  { path: 'categories', component: CategoriasComponent},
  { path: 'categories/form', component: FormCategoriasComponent},
  { path: 'categories/form/:id', component: FormCategoriasComponent},
  { path: 'brands', component: MarcasComponent},
  { path: 'brands/form', component: FormMarcasComponent},
  { path: 'brands/form/:id', component: FormMarcasComponent},
  { path: 'reviews', component: RevisionesComponent},
  { path: 'reviews/form', component: FormRevisionesComponent },
  { path: 'reviews/form/:id', component: FormCategoriasComponent},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
