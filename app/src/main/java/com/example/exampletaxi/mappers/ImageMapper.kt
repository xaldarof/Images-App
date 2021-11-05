package com.example.exampletaxi.mappers


interface ImageMapper<ImageDomain,ImageUi> {

    fun mapToUi(data:ImageDomain):ImageUi

}