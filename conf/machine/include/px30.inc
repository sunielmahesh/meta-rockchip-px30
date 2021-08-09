# Copyright (c) 2021, Amarula India Pvt Ltd
# Released under the MIT license (see COPYING.MIT for the terms)

SOC_FAMILY ?= "px30"

DEFAULTTUNE ?= "cortexa35-crypto"

require conf/machine/include/soc-family.inc
require conf/machine/include/tune-cortexa35.inc
require conf/machine/include/rockchip-wic.inc

KBUILD_DEFCONFIG ?= "defconfig"
KERNEL_CLASSES = "kernel-fitimage"
KERNEL_IMAGETYPE = "fitImage"

TFA_PLATFORM = "px30"
TFA_BUILD_TARGET = "bl31"

UBOOT_SUFFIX ?= "itb"
UBOOT_ENTRYPOINT ?= "0x280000"

SERIAL_CONSOLES = "115200;ttyS2"

