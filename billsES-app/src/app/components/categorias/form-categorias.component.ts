import { Component, OnInit } from '@angular/core';
import { Categoria } from 'src/app/classes/categoria'
import { Router, ActivatedRoute } from '@angular/router';
import { CategoriaService } from '../../services/categoria.service';
import swal from 'sweetalert2'

@Component({
  selector: 'app-form-categorias',
  templateUrl: './form-categorias.component.html',
  styleUrls: ['./form-categorias.component.css']
})
export class FormCategoriasComponent implements OnInit {

  private categoria: Categoria = new Categoria();

  private titulo: string ='Formulario de Categorias de las Categorías'
  private titulo2: string ='Creación de Categorías'

  constructor(private categoriaService: CategoriaService,
    private router: Router,
    private activateRoute: ActivatedRoute) { }

  ngOnInit() {
    this.cargarCategoria();
  }

  cargarCategoria(): void {
    this.activateRoute.params.subscribe( params => {
      let id = params['id']
      if (id) {
        this.categoriaService.getCategoria(id).subscribe((categoria) => this.categoria = categoria);
      }
    }
    );
  }

 create(): void {
   this.categoriaService.create(this.categoria)
    .subscribe(categoria => {
      this.router.navigate(['/categories'])
      swal.fire('Nueva Categoría', `Categoría ${categoria.nombre} creada con éxito!`, 'success')

    }
    );

}

update(): void {
  this.categoriaService.update(this.categoria)
    .subscribe(categoria => {
      this.router.navigate(['/categories'])
      swal.fire('Categoría Actualizada', `Categoría ${categoria.nombre} Actualizada con éxito!`, 'success');
  }
  );
}

}


/*



ngOnInit() {
  this.cargarProducto();
}

cargarProducto(): void {
  this.activateRoute.params.subscribe(params => {
    let id = params['id']
    if (id) {
      this.productoService.getProducto(id).subscribe((producto) => this.producto = producto)
    }
  }
  )
}



}

update(): void {
  this.productoService.update(this.producto)
    .subscribe(producto => {
      this.router.navigate(['/products'])
      swal.fire('Producto Actualizado', `Producto ${producto.nombre} actualizado con éxito!`, 'success')
    })
} */
