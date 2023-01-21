INSERT INTO adm_privilege VALUES (1, 'ADD_WINE');
INSERT INTO adm_privilege VALUES (2, 'ADD_PHOTO');
INSERT INTO adm_privilege VALUES (3, 'ADD_COMMENT');

INSERT INTO adm_role VALUES (1, 'USER_BASIC');
INSERT INTO adm_role VALUES (2, 'USER_PREMIUM');

INSERT INTO roles_privileges VALUES (1, 1);
INSERT INTO roles_privileges VALUES (2, 1);
INSERT INTO roles_privileges VALUES (2, 2);

INSERT INTO adm_user (id, email, first_name, subscription, password) VALUES (1, 'basic@user.com', 'peter', 1,'$2a$10$PCs.VwJxnKsHZC8vh2EKnOpcmnmOZF81Doz.m1hhlGlytugCR4cxy');

INSERT INTO users_roles VALUES (1, 1);