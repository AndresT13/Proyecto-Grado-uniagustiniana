import { Component, OnInit } from '@angular/core';
import { Producto } from 'src/app/classes/producto';
import { ProductoService } from '../../services/producto.service';
import Swal from 'sweetalert2'


@Component({
  selector: 'app-productos',
  templateUrl: './productos.component.html',
  styleUrls: ['./productos.component.css']
})

export class ProductosComponent implements OnInit {

  productos: Producto[];
 // private productoService: ProductoService;

  constructor(private productoService: ProductoService) {
   // this.productoService = productoService;
   }

  ngOnInit() {
    this.productoService.getProductos().subscribe(
      productos => this.productos = productos
    );

  }


  delete(producto: Producto): void {

    const swalWithBootstrapButtons = Swal.mixin({
      customClass: {
        confirmButton: 'btn btn-success',
        cancelButton: 'btn btn-danger'
      },
      buttonsStyling: false
    })

    swalWithBootstrapButtons.fire({
      title: 'Está seguro?',
      text: `¿Seguro que desea eliminar al producto:  ${producto.nombre} con id: ${producto.id} ?`,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Si, eliminar!',
      cancelButtonText: 'No, cancelar!',
      reverseButtons: true
    }).then((result) => {
      if (result.value) {


        this.productoService.delete(producto.id).subscribe(
          response => {
            this.productos = this.productos.filter(prod => prod !== producto)
            swalWithBootstrapButtons.fire(
              'Cliente Eliminado!',
              `Cliente ${producto.nombre} eliminado con éxito.`,
              'success'
            )

          }
        )
      }
    })

  }

}
