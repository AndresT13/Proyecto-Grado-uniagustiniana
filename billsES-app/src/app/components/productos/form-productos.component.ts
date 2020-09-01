import { Component, OnInit } from '@angular/core';
import { Producto } from 'src/app/classes/producto';
import { ProductoService } from '../../services/producto.service';
import { Router, ActivatedRoute } from '@angular/router';
import swal from 'sweetalert2'

@Component({
  selector: 'app-form-productos',
  templateUrl: './form-productos.component.html',
  styleUrls: ['./form-productos.component.css']
})
export class FormProductosComponent implements OnInit {

  private producto: Producto = new Producto();

  private titulo: string = "Formulario de Productos";
  private titulo2: string = "Creación de Productos";


  constructor(private productoService: ProductoService,
    private router: Router,
    private activateRoute: ActivatedRoute) { }

  ngOnInit() {
     this.cargarProducto();
  }

    cargarProducto(): void {
    this.activateRoute.params.subscribe( params => {
      let id = params['id']
      if (id) {
        this.productoService.getProducto(id).subscribe((producto) => this.producto = producto)
      }
    }
    );
  }

  create(): void {
    this.productoService.create(this.producto)
    .subscribe(producto =>
      {
      this.router.navigate(['/products'])
      swal.fire('Nuevo Producto', `Producto ${producto.nombre} creado con éxito!`, 'success')

    }
  );

}
  createImage(): void {
    this.productoService.addImage(this.producto)
      .subscribe(producto => {
        this.router.navigate(['/products'])
        swal.fire('Nueva Imagen', `Producto ${producto.nombre} creada con éxito!`, 'success')

      }
      );

  }

update(): void {
  this.productoService.update(this.producto)
  .subscribe( producto => {
    this.router.navigate(['/products'])
    swal.fire('Producto Actualizado', `Producto ${producto.nombre} actualizado con éxito!`, 'success' );
  }
  )
}

}
