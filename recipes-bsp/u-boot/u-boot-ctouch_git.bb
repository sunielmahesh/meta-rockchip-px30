# Copyright (c) 2021, Amarula India Pvt Ltd
# Released under the MIT license (see COPYING.MIT for the terms)

LIC_FILES_CHKSUM = "file://Licenses/README;md5=5a7450c57ffe5ae63fd732446b988025"

require u-boot-common.inc
require u-boot.inc

DEPENDS += "bc-native dtc-native python3-setuptools-native trusted-firmware-a"

SRCREV = "3823315cbedf930c52fe77452063ab6d62b157be"
SRC_URI = " \
	  git://github.com/u-boot/u-boot.git; \
	  file://0001-arm64-dts-rockchip-px30-Sync-Linux-PX30.Core-files.patch \
	  file://0002-arm64-dts-rockchip-px30-Move-dmc-into-u-boot.dtsi.patch \
	  file://0003-arm64-dts-rockchip-px30-Sync-Linux-5.14-rc3-dts-i.patch \
	  file://0004-engicam-px30-Add-Engicam-PX30.Core-C.TOUCH-2.0-10.1-.patch \
	  file://0005-engicam-Rename-board-dir-px30_core-to-px30.patch \
          "

do_compile:append:rock2-square () {
	# copy to default search path
	if [ "${SPL_BINARY}" = "u-boot-spl-dtb.bin" ]; then
		cp ${B}/spl/${SPL_BINARY} ${B}
	fi
}

ATF_DEPENDS ??= ""

EXTRA_OEMAKE:append:rk3399 = " BL31=${DEPLOY_DIR_IMAGE}/bl31-rk3399.elf"
ATF_DEPENDS:rk3399 = " virtual/trusted-firmware-a:do_deploy"
EXTRA_OEMAKE:append:rk3328 = " BL31=${DEPLOY_DIR_IMAGE}/bl31-rk3328.elf"
ATF_DEPENDS:rk3328 = " virtual/trusted-firmware-a:do_deploy"
EXTRA_OEMAKE:append:px30 = " BL31=${DEPLOY_DIR_IMAGE}/bl31-px30.elf"
ATF_DEPENDS:px30 = " virtual/trusted-firmware-a:do_deploy"

do_compile[depends] .= "${ATF_DEPENDS}"
