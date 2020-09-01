import { Component, OnInit } from '@angular/core';
import { Categoria } from 'src/app/classes/categoria';
import { CategoriaService } from '../../services/categoria.service';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-categorias',
  templateUrl: './categorias.component.html',
  styleUrls: ['./categorias.component.css']
})
export class CategoriasComponent implements OnInit {

  categoria: Categoria[];

  constructor(private categoriaService: CategoriaService) { }

  ngOnInit() {
    this.categoriaService.getCategorias().subscribe(
      categoria => this.categoria = categoria
    );
  }
  delete(categoria: Categoria): void {

    const swalWithBootstrapButtons = Swal.mixin({
      customClass: {
        confirmButton: 'btn btn-success',
        cancelButton: 'btn btn-danger'
      },
      buttonsStyling: false
    })

    swalWithBootstrapButtons.fire({
      title: 'Está seguro?',
      text: `¿Seguro que desea eliminar al producto:  ${categoria.nombre} con id: ${categoria.id} ?`,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Si, eliminar!',
      cancelButtonText: 'No, cancelar!',
      reverseButtons: true
    }).then((result) => {
      if (result.value) {


        this.categoriaService.delete(categoria.id).subscribe(
          response => {
            this.categoria = this.categoria.filter(catg => catg !== categoria)
            swalWithBootstrapButtons.fire(
              'Cliente Eliminado!',
              `Cliente ${categoria.nombre} eliminado con éxito.`,
              'success'
            )

          }
        )
      }
    })

  }


}
