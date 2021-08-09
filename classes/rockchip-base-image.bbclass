inherit core-image
require package-groups.inc

IMAGE_INSTALL += " \
    ${STANDARD_PKGS} \
    ${WIFI_SUPPORT} \
    "
