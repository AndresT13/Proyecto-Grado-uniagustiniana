import { Component, OnInit } from '@angular/core';
import { Revision } from 'src/app/classes/revision';
import { RevisionService } from '../../services/revision.service';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-revisiones',
  templateUrl: './revisiones.component.html',
  styleUrls: ['./revisiones.component.css']
})
export class RevisionesComponent implements OnInit {

  revisiones: Revision[];

  constructor(private revisionService: RevisionService) { }

  ngOnInit() {
    this.revisionService.getRevisiones().subscribe(
      revisiones => this.revisiones = this.revisiones
    );
  }

  delete(revision: Revision): void {

    const swalWithBootstrapButtons = Swal.mixin({
      customClass: {
        confirmButton: 'btn btn-success',
        cancelButton: 'btn btn-danger'
      },
      buttonsStyling: false
    })

    swalWithBootstrapButtons.fire({
      title: 'Está seguro?',
      text: `¿Seguro que desea eliminar la Revisión:  ${revision.nombre} con id: ${revision.id}?`,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Si, eliminar!',
      cancelButtonText: 'No, cancelar!',
      reverseButtons: true
    }).then((result) => {
      if (result.value) {


        this.revisionService.delete(revision.id).subscribe(
          response => {
            this.revisiones = this.revisiones.filter(rev => rev !== revision)
            swalWithBootstrapButtons.fire(
              'Revisión Eliminada!',
              `Revisión ${revision.nombre} eliminada con éxito.`,
              'success'
            )

          }
        )
      }
    })

  }


}
