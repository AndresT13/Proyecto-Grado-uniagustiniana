import { Component, OnInit } from '@angular/core';
import { Marca } from 'src/app/classes/marca';
import { MarcaService } from '../../services/marca.service';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-marcas',
  templateUrl: './marcas.component.html',
  styleUrls: ['./marcas.component.css']
})
export class MarcasComponent implements OnInit {

  marcas: Marca[];

  constructor( private marcaService: MarcaService) { }

  ngOnInit() {
    this.marcaService.getMarcas().subscribe(
      marcas => this.marcas = marcas
    );
  }

  delete(marca: Marca): void {

    const swalWithBootstrapButtons = Swal.mixin({
      customClass: {
        confirmButton: 'btn btn-success',
        cancelButton: 'btn btn-danger'
      },
      buttonsStyling: false
    })

    swalWithBootstrapButtons.fire({
      title: 'Está seguro?',
      text: `¿Seguro que desea eliminar al producto:  ${marca.nombre} con id: ${marca.id} ?`,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Si, eliminar!',
      cancelButtonText: 'No, cancelar!',
      reverseButtons: true
    }).then((result) => {
      if (result.value) {


        this.marcaService.delete(marca.id).subscribe(
          response => {
            this.marcas = this.marcas.filter(mar => mar !== marca)
            swalWithBootstrapButtons.fire(
              'Cliente Eliminado!',
              `Cliente ${marca.nombre} eliminado con éxito.`,
              'success'
            )

          }
        )
      }
    })

  }

}
