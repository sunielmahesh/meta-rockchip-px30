SECTION = "kernel"
DESCRIPTION = "CTouch2.0 Linux kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

inherit kernel

KBRANCH ?= "master"

DEPENDS += "rsync-native"

# Pull in the devicetree files into the rootfs
RDEPENDS_${KERNEL_PACKAGE_NAME}-base += "kernel-devicetree"

KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

SRCREV = "c500bee1c5b2f1d59b1081ac879d73268ab0ff17"

SRC_URI = " \
        git://git.kernel.org/pub/scm/linux/kernel/git/next/linux-next.git;protocol=https;branch=master \
        "

S = "${WORKDIR}/git"

FILES_${KERNEL_PACKAGE_NAME}-base:append = " ${nonarch_base_libdir}/modules/${KERNEL_VERSION}/modules.builtin.modinfo"
