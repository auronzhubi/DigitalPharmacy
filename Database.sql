USE [master]
GO
/****** Object:  Database [DigitalPharmacy]    Script Date: 2/4/2019 7:16:11 PM ******/
CREATE DATABASE [DigitalPharmacy]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'DigitalPharmacy', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA\DigitalPharmacy.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'DigitalPharmacy_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA\DigitalPharmacy_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [DigitalPharmacy] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [DigitalPharmacy].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [DigitalPharmacy] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [DigitalPharmacy] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [DigitalPharmacy] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [DigitalPharmacy] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [DigitalPharmacy] SET ARITHABORT OFF 
GO
ALTER DATABASE [DigitalPharmacy] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [DigitalPharmacy] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [DigitalPharmacy] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [DigitalPharmacy] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [DigitalPharmacy] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [DigitalPharmacy] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [DigitalPharmacy] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [DigitalPharmacy] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [DigitalPharmacy] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [DigitalPharmacy] SET  ENABLE_BROKER 
GO
ALTER DATABASE [DigitalPharmacy] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [DigitalPharmacy] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [DigitalPharmacy] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [DigitalPharmacy] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [DigitalPharmacy] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [DigitalPharmacy] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [DigitalPharmacy] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [DigitalPharmacy] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [DigitalPharmacy] SET  MULTI_USER 
GO
ALTER DATABASE [DigitalPharmacy] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [DigitalPharmacy] SET DB_CHAINING OFF 
GO
ALTER DATABASE [DigitalPharmacy] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [DigitalPharmacy] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [DigitalPharmacy] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [DigitalPharmacy] SET QUERY_STORE = OFF
GO
USE [DigitalPharmacy]
GO
ALTER DATABASE SCOPED CONFIGURATION SET IDENTITY_CACHE = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION SET LEGACY_CARDINALITY_ESTIMATION = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET LEGACY_CARDINALITY_ESTIMATION = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 0;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET MAXDOP = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET PARAMETER_SNIFFING = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET PARAMETER_SNIFFING = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET QUERY_OPTIMIZER_HOTFIXES = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET QUERY_OPTIMIZER_HOTFIXES = PRIMARY;
GO
USE [DigitalPharmacy]
GO
/****** Object:  User [Auron]    Script Date: 2/4/2019 7:16:12 PM ******/
CREATE USER [Auron] WITHOUT LOGIN WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  Table [dbo].[Farmacia]    Script Date: 2/4/2019 7:16:12 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Farmacia](
	[Farmacia_ID] [int] IDENTITY(1,1) NOT NULL,
	[Emri] [varchar](50) NOT NULL,
	[Adresa] [varchar](100) NULL,
	[NrKontaktues] [varchar](15) NULL,
 CONSTRAINT [PK__Farmacia__D7B0AC19C9794A1B] PRIMARY KEY CLUSTERED 
(
	[Farmacia_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Fatura]    Script Date: 2/4/2019 7:16:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Fatura](
	[Fatura_ID] [int] IDENTITY(1,1) NOT NULL,
	[DataLeshimit] [date] NULL,
	[NrProdukteve] [int] NULL,
	[QmimiTotal] [decimal](18, 2) NULL,
	[Klienti_ID] [int] NULL,
	[Farmacia_ID] [int] NULL,
 CONSTRAINT [PK__Fatura__AD420DB3FA26AF6E] PRIMARY KEY CLUSTERED 
(
	[Fatura_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Furnizuesi]    Script Date: 2/4/2019 7:16:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Furnizuesi](
	[Furnizuesi_ID] [int] IDENTITY(1,1) NOT NULL,
	[EmriFurnizuesit] [varchar](50) NOT NULL,
	[NumriTelefonit] [varchar](20) NULL,
	[Komuna_ID] [int] NULL,
	[Farmacia_ID] [int] NULL,
 CONSTRAINT [PK__Furnizue__6202F9284F9F742B] PRIMARY KEY CLUSTERED 
(
	[Furnizuesi_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Klienti]    Script Date: 2/4/2019 7:16:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Klienti](
	[Klienti_ID] [int] IDENTITY(1,1) NOT NULL,
	[Emri] [varchar](50) NOT NULL,
	[Mbiemri] [varchar](50) NOT NULL,
	[DataLindjes] [date] NOT NULL,
	[Gjinia] [char](1) NULL,
	[NrTelefonit] [varchar](35) NOT NULL,
	[Komuna_ID] [int] NULL,
	[EmriRruges] [varchar](50) NOT NULL,
	[NumriHyrjes] [int] NULL,
	[Kati] [int] NULL,
	[Pershkrimi] [varchar](150) NULL,
 CONSTRAINT [PK__Klienti__2F6B0E5EC6908549] PRIMARY KEY CLUSTERED 
(
	[Klienti_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Komuna]    Script Date: 2/4/2019 7:16:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Komuna](
	[Komuna_ID] [int] IDENTITY(1,1) NOT NULL,
	[EmriKomunes] [varchar](50) NOT NULL,
 CONSTRAINT [PK__Komuna__54295DC8C90C35BB] PRIMARY KEY CLUSTERED 
(
	[Komuna_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LlojiProduktit]    Script Date: 2/4/2019 7:16:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LlojiProduktit](
	[LlojiProduktit_ID] [int] IDENTITY(1,1) NOT NULL,
	[LlojiProduktit] [varchar](50) NULL,
 CONSTRAINT [PK__LlojiPro__C9F6AAFA09861D3E] PRIMARY KEY CLUSTERED 
(
	[LlojiProduktit_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Perdoruesit]    Script Date: 2/4/2019 7:16:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Perdoruesit](
	[PerdoruesiID] [int] IDENTITY(1,1) NOT NULL,
	[EmriPerdoruesit] [varchar](50) NOT NULL,
	[Fjalekalimi] [varchar](50) NOT NULL,
	[NiveliPerdorimit] [varchar](40) NOT NULL,
	[Farmacia_ID] [int] NULL,
 CONSTRAINT [PK__Perdorue__AD15B44BF7BB4867] PRIMARY KEY CLUSTERED 
(
	[PerdoruesiID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ProduktetEFatures]    Script Date: 2/4/2019 7:16:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ProduktetEFatures](
	[Fatura_ID] [int] NULL,
	[Produkti_ID] [int] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ProduktetEFurnizuesit]    Script Date: 2/4/2019 7:16:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ProduktetEFurnizuesit](
	[ProduktetEFurnizuesitID] [int] IDENTITY(1,1) NOT NULL,
	[Furnizuesi_ID] [int] NULL,
	[Produkti_ID] [int] NULL,
 CONSTRAINT [PK_ProduktetEFurnizuesit] PRIMARY KEY CLUSTERED 
(
	[ProduktetEFurnizuesitID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ProduktetETerapise]    Script Date: 2/4/2019 7:16:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ProduktetETerapise](
	[ProduktetETerapise_ID] [int] IDENTITY(1,1) NOT NULL,
	[Terapia_ID] [int] NOT NULL,
	[Produkti_ID] [int] NOT NULL,
	[Doza] [int] NULL,
	[Ditore] [int] NULL,
 CONSTRAINT [PK_ProduktetETerapise] PRIMARY KEY CLUSTERED 
(
	[ProduktetETerapise_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Produkti]    Script Date: 2/4/2019 7:16:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Produkti](
	[Produkti_ID] [int] NOT NULL,
	[NumriSerik] [int] NOT NULL,
	[Emri] [varchar](100) NOT NULL,
	[PerbersiBaze] [varchar](100) NULL,
	[DataSkadimit] [date] NOT NULL,
	[NumriTabletave] [int] NULL,
	[LlojiProduktit_ID] [int] NULL,
	[Qmimi] [decimal](18, 2) NULL,
	[QmimiFurnizues] [decimal](18, 2) NULL,
	[Prodhuesi] [varchar](50) NULL,
	[ShtetiProdhimit] [varchar](50) NULL,
 CONSTRAINT [PK__Produkti__CE60638E88788397] PRIMARY KEY CLUSTERED 
(
	[Produkti_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Stafi]    Script Date: 2/4/2019 7:16:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Stafi](
	[Stafi_ID] [int] IDENTITY(1,1) NOT NULL,
	[Emri] [varchar](50) NOT NULL,
	[Mbiemri] [varchar](50) NOT NULL,
	[DataLindjes] [date] NOT NULL,
	[Gjinia] [char](1) NULL,
	[Tipi_ID] [int] NULL,
	[Farmacia_ID] [int] NULL,
 CONSTRAINT [PK__Stafi__7B50434704E96373] PRIMARY KEY CLUSTERED 
(
	[Stafi_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Terapia]    Script Date: 2/4/2019 7:16:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Terapia](
	[Terapia_ID] [int] IDENTITY(1,1) NOT NULL,
	[Kohezgjatja] [int] NULL,
	[Klienti_ID] [int] NULL,
 CONSTRAINT [PK__Terapia__E94843683F0B5DE8] PRIMARY KEY CLUSTERED 
(
	[Terapia_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TipiStafit]    Script Date: 2/4/2019 7:16:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TipiStafit](
	[Tipi_ID] [int] IDENTITY(1,1) NOT NULL,
	[LlojiTipit] [varchar](40) NOT NULL,
 CONSTRAINT [PK__TipiStaf__633D40CA0A072C8F] PRIMARY KEY CLUSTERED 
(
	[Tipi_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Fatura]  WITH CHECK ADD  CONSTRAINT [FK__Fatura__Farmacia__619B8048] FOREIGN KEY([Farmacia_ID])
REFERENCES [dbo].[Farmacia] ([Farmacia_ID])
GO
ALTER TABLE [dbo].[Fatura] CHECK CONSTRAINT [FK__Fatura__Farmacia__619B8048]
GO
ALTER TABLE [dbo].[Fatura]  WITH CHECK ADD  CONSTRAINT [FK__Fatura__Klienti___60A75C0F] FOREIGN KEY([Klienti_ID])
REFERENCES [dbo].[Klienti] ([Klienti_ID])
GO
ALTER TABLE [dbo].[Fatura] CHECK CONSTRAINT [FK__Fatura__Klienti___60A75C0F]
GO
ALTER TABLE [dbo].[Furnizuesi]  WITH CHECK ADD  CONSTRAINT [FK__Furnizues__Farma__68487DD7] FOREIGN KEY([Farmacia_ID])
REFERENCES [dbo].[Farmacia] ([Farmacia_ID])
GO
ALTER TABLE [dbo].[Furnizuesi] CHECK CONSTRAINT [FK__Furnizues__Farma__68487DD7]
GO
ALTER TABLE [dbo].[Furnizuesi]  WITH CHECK ADD  CONSTRAINT [FK__Furnizues__Komun__6754599E] FOREIGN KEY([Komuna_ID])
REFERENCES [dbo].[Komuna] ([Komuna_ID])
GO
ALTER TABLE [dbo].[Furnizuesi] CHECK CONSTRAINT [FK__Furnizues__Komun__6754599E]
GO
ALTER TABLE [dbo].[Klienti]  WITH CHECK ADD  CONSTRAINT [FK__Klienti__Komuna___5812160E] FOREIGN KEY([Komuna_ID])
REFERENCES [dbo].[Komuna] ([Komuna_ID])
GO
ALTER TABLE [dbo].[Klienti] CHECK CONSTRAINT [FK__Klienti__Komuna___5812160E]
GO
ALTER TABLE [dbo].[Perdoruesit]  WITH CHECK ADD  CONSTRAINT [FK__Perdorues__Farma__6E01572D] FOREIGN KEY([Farmacia_ID])
REFERENCES [dbo].[Farmacia] ([Farmacia_ID])
GO
ALTER TABLE [dbo].[Perdoruesit] CHECK CONSTRAINT [FK__Perdorues__Farma__6E01572D]
GO
ALTER TABLE [dbo].[ProduktetEFatures]  WITH CHECK ADD  CONSTRAINT [FK__Produktet__Fatur__6383C8BA] FOREIGN KEY([Fatura_ID])
REFERENCES [dbo].[Fatura] ([Fatura_ID])
GO
ALTER TABLE [dbo].[ProduktetEFatures] CHECK CONSTRAINT [FK__Produktet__Fatur__6383C8BA]
GO
ALTER TABLE [dbo].[ProduktetEFatures]  WITH CHECK ADD  CONSTRAINT [FK__Produktet__Produ__6477ECF3] FOREIGN KEY([Produkti_ID])
REFERENCES [dbo].[Produkti] ([Produkti_ID])
GO
ALTER TABLE [dbo].[ProduktetEFatures] CHECK CONSTRAINT [FK__Produktet__Produ__6477ECF3]
GO
ALTER TABLE [dbo].[ProduktetEFurnizuesit]  WITH CHECK ADD  CONSTRAINT [FK__Produktet__Furni__6A30C649] FOREIGN KEY([Furnizuesi_ID])
REFERENCES [dbo].[Furnizuesi] ([Furnizuesi_ID])
GO
ALTER TABLE [dbo].[ProduktetEFurnizuesit] CHECK CONSTRAINT [FK__Produktet__Furni__6A30C649]
GO
ALTER TABLE [dbo].[ProduktetEFurnizuesit]  WITH CHECK ADD  CONSTRAINT [FK__Produktet__Produ__6B24EA82] FOREIGN KEY([Produkti_ID])
REFERENCES [dbo].[Produkti] ([Produkti_ID])
GO
ALTER TABLE [dbo].[ProduktetEFurnizuesit] CHECK CONSTRAINT [FK__Produktet__Produ__6B24EA82]
GO
ALTER TABLE [dbo].[ProduktetETerapise]  WITH CHECK ADD  CONSTRAINT [FK__Produktet__Produ__5DCAEF64] FOREIGN KEY([Produkti_ID])
REFERENCES [dbo].[Produkti] ([Produkti_ID])
GO
ALTER TABLE [dbo].[ProduktetETerapise] CHECK CONSTRAINT [FK__Produktet__Produ__5DCAEF64]
GO
ALTER TABLE [dbo].[ProduktetETerapise]  WITH CHECK ADD  CONSTRAINT [FK__Produktet__Terap__5CD6CB2B] FOREIGN KEY([Terapia_ID])
REFERENCES [dbo].[Terapia] ([Terapia_ID])
GO
ALTER TABLE [dbo].[ProduktetETerapise] CHECK CONSTRAINT [FK__Produktet__Terap__5CD6CB2B]
GO
ALTER TABLE [dbo].[Produkti]  WITH CHECK ADD  CONSTRAINT [FK__Produkti__LlojiP__534D60F1] FOREIGN KEY([LlojiProduktit_ID])
REFERENCES [dbo].[LlojiProduktit] ([LlojiProduktit_ID])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Produkti] CHECK CONSTRAINT [FK__Produkti__LlojiP__534D60F1]
GO
ALTER TABLE [dbo].[Stafi]  WITH CHECK ADD  CONSTRAINT [FK__Stafi__Farmacia___4E88ABD4] FOREIGN KEY([Farmacia_ID])
REFERENCES [dbo].[Farmacia] ([Farmacia_ID])
GO
ALTER TABLE [dbo].[Stafi] CHECK CONSTRAINT [FK__Stafi__Farmacia___4E88ABD4]
GO
ALTER TABLE [dbo].[Stafi]  WITH CHECK ADD  CONSTRAINT [FK__Stafi__Tipi_ID__4D94879B] FOREIGN KEY([Tipi_ID])
REFERENCES [dbo].[TipiStafit] ([Tipi_ID])
GO
ALTER TABLE [dbo].[Stafi] CHECK CONSTRAINT [FK__Stafi__Tipi_ID__4D94879B]
GO
ALTER TABLE [dbo].[Terapia]  WITH CHECK ADD  CONSTRAINT [FK__Terapia__Klienti__5AEE82B9] FOREIGN KEY([Klienti_ID])
REFERENCES [dbo].[Klienti] ([Klienti_ID])
GO
ALTER TABLE [dbo].[Terapia] CHECK CONSTRAINT [FK__Terapia__Klienti__5AEE82B9]
GO
USE [master]
GO
ALTER DATABASE [DigitalPharmacy] SET  READ_WRITE 
GO
