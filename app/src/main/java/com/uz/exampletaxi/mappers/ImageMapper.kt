package com.uz.exampletaxi.mappers


interface ImageMapper<ImageDomain,ImageUi> {

    fun mapToUi(data:ImageDomain):ImageUi

}